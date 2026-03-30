package systementor.cidemo1;

//la till detta för att kunna göra mockning 
//package systementor.cidemo1; DENNA FANNS JU REDAN
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
//END 

//la till detta
@ExtendWith(MockitoExtension.class) //se steg 3.2 i lathunden


public class CountryServiceTest {

    //la också till detta, se steg 3.2. i lathunden
    @Mock
    CountryApiClient apiClient;

    @InjectMocks
    CountryService countryService;
    //END

    // <------------------------- HÄR SKA SJÄLVA MOCKNINGEN IN! -------------------------
    // ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️
    private static final Country LATVIA = new Country(
        "Latvia",
        "Republic of Latvia",
        "Latvija",
        "Latvijas Republikas",
        "Riga",
        "Europe",
        "Northern Europe",
        Map.of(
            "lav", "Latvian",
            "eng", "English"
        ),
        List.of("EST", "LTU", "RUS", "BLR"),
        1829000,
        64559.0,
        "https://goo.gl/maps/iQpUkh7ghq31ztXs9"
    );
    // ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️
    // <-------------------------------------------------------------------
    // <------------------------- HÄR ÄR MIN EGNA NYA MOCK! -------------------------
    // ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️ ⬇️
    private static final Country KURDISTAN = new Country(
        "Kurdistan",
        "Kurdistan Region",
        "Kurdistân",
        "Herêma Kurdistanê",
        "Erbil",
        "Asia",
        "Middle East",
        Map.of(
            "ckb", "Central Kurdish",
            "kmr", "Northern Kurdish",
            "ara", "Arabic"
        ),
        List.of("TUR", "IRN", "SYR", "IRQ"), // Grannar/Gränser
        60000000,                             // Population (ca)
        470643.0,                             // Area (km2)
        "https://goo.gl/maps/kurdistan_map_link"
    );
    // ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️ ⬆️
    // <-------------------------------------------------------------------------

    @Test
    void getSortedLaungagesReturnsAlphabeticallySortedLangues() {
        when(countryApiClient.fetchCountryByName("Latvia"))
            .thenReturn(LATVIA);

        var result = countryService.getSortedBorders("Latvia");

        assertEquals(List.of("English", "Latvian"), result);
    }

}
