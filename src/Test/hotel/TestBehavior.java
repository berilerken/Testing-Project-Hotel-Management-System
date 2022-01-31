package hotel;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class TestBehavior
{


    @Test
    public void testBehavior()throws Exception
    {
        LoginClass loginClass = Mockito.mock(LoginClass.class);
        loginClass.save(new Customer(1,"Beril","Ankara","90234983298","customer"));
        verify(loginClass).save(new Customer(1,"Beril","Ankara","90234983298","customer"));

    }

}