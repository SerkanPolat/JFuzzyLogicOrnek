package odev;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class Contraceptive {
	
	int Wife_Age;
	int Wife_Education;
	int Husband_Education;
	int NumberOf_Children;
	int Wife_Religion;
	int Wife_Working;
	int Husband_Occupation;
	int Living_Index;
	int Media_Exposure;
    private FIS fis;
    public Contraceptive(int wife_Age, int wife_Education, int husband_Education, int numberOf_Children, int wife_Religion,
			int wife_Working, int husband_Occupation, int living_Index, int media_Exposure) throws URISyntaxException, IOException {

		Wife_Age = wife_Age;
		Wife_Education = wife_Education;
		Husband_Education = husband_Education;
		NumberOf_Children = numberOf_Children;
		Wife_Religion = wife_Religion;
		Wife_Working = wife_Working;
		Husband_Occupation = husband_Occupation;
		Living_Index = living_Index;
		Media_Exposure = media_Exposure;
		   
        File dosya = new File(getClass().getResource("contraceptive.fcl").toURI());
        fis = FIS.load(dosya.getPath(),true);
        fis.setVariable("Wife_Age",Wife_Age);
        fis.setVariable("Wife_Education", Wife_Education);
        fis.setVariable("Husband_Education", Husband_Education);
        fis.setVariable("NumberOf_Children", NumberOf_Children);
        fis.setVariable("Wife_Religion", Wife_Religion);
        fis.setVariable("Wife_Working", Wife_Working);
        fis.setVariable("Husband_Occupation", Husband_Occupation);
        fis.setVariable("Living_Index", Living_Index);
        fis.setVariable("Media_Exposure", Media_Exposure);
        fis.evaluate();
    }

    @Override
    public String toString(){
    	
        String cikti = ""+fis.getVariable("Contraceptive").getValue();
        return cikti;
    }
    
    public float getir(){
    	
    	return (float)fis.getVariable("Contraceptive").getValue();
    	
    }
    
    
    FIS getModel() {
    	return fis;
    }
	
}
