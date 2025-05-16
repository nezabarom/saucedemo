package stepDefinitions.base;

import com.saucedemo.core.config.manager.ConfigManager;
import com.saucedemo.core.config.EnvironmentConfig;
import io.cucumber.java.After;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class BaseApiTests {

    private final EnvironmentConfig ENV_CONFIG = ConfigManager.getEnvironmentConfig();



    @After(value = "@DeleteCorporateEntry")
    public void deleteEntriesForOffice() {

    }

    @After(value = "@DeleteCorporateEntryFromNotDefaultLocation")
    public void deleteCorporateEntryFromNotDefaultLocation() {

    }

    @After(value = "@DeleteReminders")
    public void deleteReminders() {

    }

    @After(value = "@DeleteAllGreenEnergyCertificatesFromLocation")
    public void deleteAllGreenEnergyCertificatesFromLocation() {

    }

    @After(value = "@DeleteVehicles")
    public void deleteVehicles() {


    }

    @After(value = "@DeleteEquipment")
    public void deleteEquipment() {

    }

    @After(value = "@DeleteAllFuelConsumptionEntries")
    public void deleteAllFuelConsumptionEntries() {

    }
}