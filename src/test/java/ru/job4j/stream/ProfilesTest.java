package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void collectAddresses() {
        Address address1 = new Address(
                "Moscow", "Aviamotornaya", 65, 100
        );
        Profile profile1 = new Profile(address1);
        Profile profile3 = profile1;
        Address address2 = new Address(
                "Kazan", "Baumana", 15, 5
        );
        Profile profile2 = new Profile(address2);
        Profile profile4 = profile2;
        List<Address> rsl = Profiles.collect(
                List.of(profile1, profile2, profile3, profile4));
        List<Address> expected = List.of(address2, address1);
        assertThat(rsl, is(expected));
    }
}