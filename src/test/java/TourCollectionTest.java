package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.memoranda.TourCollection;
import main.java.memoranda.TourImpl;

class TourCollectionTest {
    
    String tourCollectionFilePath = "src/main/resources/data/tours/tours.json";
    TourCollection testCollection = new TourCollection();
    TourCollection testCollection2 = new TourCollection(tourCollectionFilePath);

    @Test
    public void EmptyTourTest() {
        assertTrue(testCollection.getTourList() == null);
    }
    
    @Test
    public void FullTourCollection() {
        assertTrue(testCollection2.getTourList() != null);
    }
    
    @Test
    public void DoesContainTour() {
        String tourID = "0004";
        assertNotNull(testCollection2.getTour(tourID) != null);
    }
    
    @Test
    public void CanAddTour() {
        TourImpl newTour = new TourImpl("0002","R006","D002","B4343","8:30AM","01/01/2018");
        testCollection2.addTour(newTour);
        assertTrue(testCollection2.getTour("0002") != null);
    }
    
    @Test
    public void CanRemoveTour() {
        TourImpl newTour = new TourImpl("0002","R006","D002","B4343","8:30AM","01/01/2018");
        testCollection2.addTour(newTour);
        testCollection2.removeTour(newTour);
        assertTrue(!testCollection2.getTourList().contains(newTour));
    }
    
    @Test
    public void DoesExportTourCollection() {
        TourCollection testCollection3;
        TourImpl newTour = new TourImpl("0002","R006","D002","B4343","8:30AM","01/01/2018");
        testCollection2.addTour(newTour);
        testCollection2.exportTourCollection();
        testCollection3 = new TourCollection(tourCollectionFilePath);
        assertTrue(testCollection3.getTour("0002").getTourID().equals(newTour.getTourID()));
    }

}
