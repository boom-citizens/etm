package uz.boom.citizens.exceptions;

import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

public final class FlashMap extends HashMap<String, Object> implements Comparable<FlashMap> {

    @Nullable
    private String targetRequestPath;

    private final MultiValueMap<String, String> targetRequestParams
            = new LinkedMultiValueMap<>(4);

    private long expirationTime = -1;

    @Override
    public int compareTo(FlashMap o) {
        return 0;
    }
}
