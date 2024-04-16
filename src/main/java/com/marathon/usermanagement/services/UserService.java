@Service
public class UserService {

    private UserRepository userRepository;
    private KafkaSenderService kafkaSenderService;

    @Autowired
    public UserService(UserRepository userRepository, KafkaSenderService kafkaSenderService) {
        this.userRepository = userRepository;
        this.kafkaSenderService = kafkaSenderService;
    }

    public void sendUserByIdToKafka(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            String userJson = convertUserToJson(user);
            kafkaSenderService.sendUser("user-topic", userJson);
        }
    }

    private String convertUserToJson(User user) {
        // Convert the user object to JSON
        // You can use libraries like Jackson or Gson for this
    }
}