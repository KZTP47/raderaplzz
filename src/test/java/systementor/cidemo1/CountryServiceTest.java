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

    @Test
    void getSortedLaungagesReturnsAlphabeticallySortedLangues() {
        when(countryApiClient.fetchCountryByName("Latvia"))
            .thenReturn(LATVIA);

        var result = countryService.getSortedBorders("Latvia");

        assertEquals(List.of("English", "Latvian"), result);
    }

}
