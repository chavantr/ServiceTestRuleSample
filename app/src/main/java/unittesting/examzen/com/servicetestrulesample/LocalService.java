package unittesting.examzen.com.servicetestrulesample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class LocalService extends Service {


    // Used as a key for the Intent.
    public static final String SEED_KEY = "SEED_KEY";

    // Binder given to clients
    private final IBinder binder = new LocalBinder();

    private Random random = new Random();

    private long seed;


    public LocalService() {


    }

    @Override
    public IBinder onBind(Intent intent) {
        if (intent.hasExtra(SEED_KEY)) {
            seed = intent.getLongExtra(SEED_KEY, 0);
            random.setSeed(seed);
        }
        return binder;
    }

    public class LocalBinder extends Binder {
        public LocalService getService() {
            return LocalService.this;
        }
    }

    /**
     * Returns a random integer in [0, 100).
     */
    public int getRandomInt() {
        return random.nextInt(100);
    }

}
