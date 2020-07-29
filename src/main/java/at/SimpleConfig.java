package at;

import org.aeonbits.owner.Config;
import static org.aeonbits.owner.Config.*;

@LoadPolicy(LoadType.MERGE)
@Sources({
        "classpath:config.properties",
        "classpath:testData.properties"
})

public interface SimpleConfig extends Config {

    String browser();
    String remoteBrowserVersion();
    String baseUrl();
}
