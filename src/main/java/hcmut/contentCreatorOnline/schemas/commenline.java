package hcmut.contentCreatorOnline.schemas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;

@Component
public class commenline implements CommandLineRunner {
        // @Autowired
        // private jdbc repositJdbc;
        // @Autowired
        // private jpa repositJpa;
        @Autowired
        private springDataJpa repositJpa;

        @Override
        public void run(String... args) throws Exception {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                repositJpa
                                .save(new Creation((long) 1, "creationName1jpa", dateFormat.parse("01/01/2024"), true,
                                                true,
                                                1000000, 100, 100, "sdfsdf", "sdfsdfsdf"));
                repositJpa
                                .save(new Creation((long) 2, "creationName2jpa", dateFormat.parse("01/01/2024"), true,
                                                true, 1000000, 100, 100, "sdfsd", "sdfds"));
                // repositJpa
                // .save(new Creation((long) 3, "creationName2jpa",
                // dateFormat.parse("01/01/2024"), true, true,
                // 1000000));
                // repositJpa
                // .save(new Creation((long) 5, "creationName5jpa",
                // dateFormat.parse("01/01/2024"), true, true, 1000000));
                // repositJpa
                // .save(new Creation((long) 4, "creationName2", dateFormat.parse("01/01/2024"),
                // true, true, 1000000));

                repositJpa.deleteById(1l);
                System.out.println(repositJpa.findById(1l));
                System.out.println(repositJpa.findById(3l));

                System.out.println(repositJpa.findAll());
        }
}
