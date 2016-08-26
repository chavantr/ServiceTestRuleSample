package unittesting.examzen.com.servicetestrulesample;

import android.content.Intent;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.MediumTest;

import org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Tatyabhau Chavan on 8/26/2016.
 */
@MediumTest
@RunWith(AndroidJUnit4.class)
public class LocalServiceTest {


    @Rule
    public final ServiceTestRule serviceTestRule = new ServiceTestRule();


    @Test
    public void testWithBoundService() throws TimeoutException {

        Intent intent = new Intent(InstrumentationRegistry.getTargetContext(), LocalService.class);

        intent.putExtra(LocalService.SEED_KEY, 42L);

        IBinder binder = serviceTestRule.bindService(intent);

        LocalService service = ((LocalService.LocalBinder) binder).getService();

        assertThat(service.getRandomInt(), is(any(Integer.class)));

    }

}
