import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class GetRequestTest {

    @Test
    public void rest (){


        // TODO given it بتاخد url
        //TODO when take a name of end point which creation هنا كدا كريت جوه موقع الموك اند بوينت وسميتها كدا
        //TODO print all body of end point
        //TODO assert for first name of first body have index [0] if name equal mohamed
        //TODO hasItem    mean if any attribute at any body if have more body named age = 27years
        //TODO hasItems  check for more item بتشك عن اكتر من رقم مثلا ف اى باضى موجود ولازم يبقي الاتنين صح
        RestAssured
                // TODO given it بتاخد url
                .given().baseUri("https://68340f96464b49963601213a.mockapi.io/api/v1/")
                //TODO when take a name of end point which creation هنا كدا كريت جوه موقع الموك اند بوينت وسميتها كدا
                .when().get("Task_SheenInfo")
                //TODO print all body of end point
                .then().log().all()
                .assertThat().statusCode(200)
                //TODO assert for first name of first body have index [0] if name equal mohamed
                .assertThat().body("[0].FrstName",equalTo("Mohamed"))
                //TODO hasItem    mean if any attribute at any body if have more body named age = 27years
                .assertThat().body("age",hasItem("27years"))
                //TODO hasItems  check for more item بتشك عن اكتر من رقم مثلا ف اى باضى موجود ولازم يبقي الاتنين صح
             //   .assertThat().body("PhoneNumber",hasItems("01552352610","0100000"))
                //TODO body not have this
                .assertThat().body("PhoneNumber",not("010"))
                //TODO chek if that not empty
                .assertThat().body("avatar",not(empty()))
                //TODO chek if that has a 1 attribute
                .assertThat().body("Email",hasSize(1))
                //TODO verify avatar in all body start https
                .assertThat().body("avatar",everyItem(startsWith("https")))
                //TODO check if  first body have a key named LastName
                .assertThat().body("[0]",hasKey("LastName"))
                //TODO check if body has a this value in any key
                .assertThat().body("[0]",hasValue("https://i.postimg.cc/5tsN9bVH/mohamed.jpg"))
               //TODO make sure this key have a this value
                .assertThat().body("[0]",hasEntry("FrstName","Mohamed"))
        ;








    }



}
