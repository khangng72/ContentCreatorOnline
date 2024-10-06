package hcmut.contentCreatorOnline;

import java.util.Arrays;
import java.util.List;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.RestController;

import hcmut.contentCreatorOnline.schemas.Creation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class creationCtroller {

    @RequestMapping("/Creation")
    public List<Creation> retriveAllCreation() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return Arrays.asList(

                new Creation((long) 1, "creationName1", dateFormat.parse("01/01/2024"), true, true, 1000000),

                new Creation((long) 2, "creationName2", dateFormat.parse("01/01/2024"), true, true, 1000000));
    }
}
