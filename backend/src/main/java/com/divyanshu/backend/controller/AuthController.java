@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {


    @Autowired
    private AuthService authService;




    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtService jwtService;


    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    private LogService logService;


    @Autowired
    private ReportService reportService;


    @PostMapping("/register")
    public ResponseEntity<UserDto>  register(@RequestBody User user){
        Log log = new Log();


        log.setContent(user.toString());
        log.setAction("User Registered :");
        log.setUser(user);


        UserDto user1 = authService.register(user);
        if(user1 != null){
            Log log2 = logService.saveLog(log);


            Report report = new Report();
            report.setContent("Registration happened");
            report.setLog(log2);




            reportService.saveReport(report);
        }
        return  ResponseEntity.ok(user1);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getName(), user.getPswrd()
                    )
            );
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getName());
            System.out.println("Details " + userDetails);
            String jwt = jwtService.generteToken(userDetails);
            System.out.println("Jwt " + jwt);
            return ResponseEntity.ok(Collections.singletonMap("token", jwt));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Collections.singletonMap("error", e.getMessage()));
        }
    }
}
