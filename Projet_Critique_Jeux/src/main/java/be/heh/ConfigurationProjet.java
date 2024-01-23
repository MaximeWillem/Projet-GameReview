package be.heh;
import be.heh.adapter.persistance.Repository.CommentRepository;
import be.heh.adapter.persistance.Repository.GameRepository;
import be.heh.adapter.persistance.Repository.UserRepository;
import be.heh.adapter.persistance.persistance.AdaptateurCommentPersistance;
import be.heh.adapter.persistance.persistance.AdaptateurGamePersistance;
import be.heh.adapter.persistance.persistance.AdaptateurUserPersistance;
import be.heh.application.domain.service.CommentService;
import be.heh.application.domain.service.GameService;
import be.heh.application.domain.service.UserService;
import be.heh.port.in.CommentUseCase;
import be.heh.port.in.GameUseCase;
import be.heh.port.in.UserUseCase;
import be.heh.port.out.CommentPersistance;
import be.heh.port.out.GamePersistance;
import be.heh.port.out.UserPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
@EnableJdbcRepositories

@Configuration

public class ConfigurationProjet {


        @Autowired
        CommentRepository commentRepository;
        CommentPersistance commentPersistance;

        @Autowired
        GameRepository gameRepository;
        GamePersistance gamePersistance;

        @Autowired
        UserRepository userRepository;
        UserPersistance userPersistance;

        @Bean
        public CommentUseCase getCommentUseCase() {
            return new CommentService(new AdaptateurCommentPersistance(commentRepository));
        }

        @Bean
        public GameUseCase getGameUseCase() {
            return new GameService(new AdaptateurGamePersistance(gameRepository));
        }

        @Bean
        public UserUseCase getUserUseCase() {
            return new UserService(new AdaptateurUserPersistance(userRepository));
        }
    }


