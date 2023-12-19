package tn.teams.RH.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import tn.teams.RH.configsecurite.JwtUtils;
import tn.teams.RH.dto.AuthenticationRequest;
import tn.teams.RH.dto.AuthenticationResponse;
import tn.teams.RH.dto.Employeedto;
import tn.teams.RH.dto.RegistrationRequest;
import tn.teams.RH.modeles.Departement;
import tn.teams.RH.modeles.Employee;
import tn.teams.RH.modeles.Role;
import tn.teams.RH.modeles.User;
import tn.teams.RH.repository.DepartementRepository;
import tn.teams.RH.repository.EmployeeRepository;
import tn.teams.RH.repository.RoleRepository;
import tn.teams.RH.repository.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceimpl implements UserService {
	private final UserRepository repository;
	private final EmployeeRepository emprepository;
	private final RoleRepository rolerepository;
	private final DepartementRepository dptrepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtUtils jwtUtils;
	private final AuthenticationManager authenticationManager;

	@Override
	public AuthenticationResponse register(RegistrationRequest userdto) {

		User user;
		User savedUser = null;
		if (userdto instanceof Employeedto) {
			user = new Employee();
			user = Employeedto.toEntity((Employeedto) userdto);
			///// role
			Set<String> strRoles = userdto.getRole();
			Set<Role> roles = new HashSet<>();
			// System.err.println(strRoles[]);
			if (strRoles == null) {
				Role userRole = rolerepository.findByName("EMPLOYEE")
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
			} else {
				strRoles.forEach(role -> {

					Role adminRole = rolerepository.findByName(role)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

				});
			}
			user.setRoles(roles);
			/////
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			savedUser = emprepository.save((Employee) user);
		}

		Map<String, Object> claims = new HashMap<>();
		claims.put("userId", savedUser.getIduser()); // optional
		claims.put("fullName", savedUser.getFullname()); // optional

		// generate a JWT token
		String token = jwtUtils.generateToken(savedUser, claims);
		return AuthenticationResponse.builder().token(token).build();
	}

	@Override
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		final User user = repository.findByEmail(request.getEmail()).get();
		Map<String, Object> claims = new HashMap<>();
		claims.put("userId", user.getIduser()); // optional
		claims.put("fullName", user.getFullname()); // optional
		// generate a JWT token
		String token = jwtUtils.generateToken(user, claims);
		return AuthenticationResponse.builder().token(token).build();
	}

	@Override
	public void createadmine() {
		//create role
		if (!rolerepository.existsByName("ADMIN")) {
			Role roleAdmin = new Role();
			roleAdmin.setName("ADMIN");
			Role dpt = rolerepository.save(roleAdmin);
			

		}
		if (!rolerepository.existsByName("EMPLOYEE")) {
			Role roleAdmin = new Role();
			roleAdmin.setName("EMPLOYEE");
			Role dpt = rolerepository.save(roleAdmin);
			

		}
		Employee userAdmin = new Employee();
		User savedUser = null;
		String email = "amall@gmail.com";
		if (!emprepository.existsByEmail(email)) {
			userAdmin.setEmail("amall@gmail.com");
			userAdmin.setFullname("amall amall");
			userAdmin.setPassword(new BCryptPasswordEncoder().encode("1234"));
			userAdmin.setGradeempl("responsablegn");
			Date aujourdhui = new Date();
			userAdmin.setDatenaissance(aujourdhui);
			userAdmin.setDateembauche(aujourdhui);
			Set<Role> roles = new HashSet<>();
			Role userRole = rolerepository.findByName("ADMIN")
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
			userAdmin.setRoles(roles);
			String name = "RH";
			if (!dptrepository.existsByNamedpt(name)) {
				Departement dptAdmin = new Departement();
				dptAdmin.setNamedpt("RH");
				Departement dpt = dptrepository.save(dptAdmin);
				

			}
			Departement dptRH = dptrepository.findByNamedpt(name);
			//userAdmin.setDepartement(dptRH);
			
			savedUser = emprepository.save(userAdmin);
		}

	}

}
