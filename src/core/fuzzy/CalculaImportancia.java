package core.fuzzy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class CalculaImportancia {

    public Map<Double,String> executa(InputFuzzy input, boolean chart){
        String aval = "";
        String filename = "fcl/sentimentParesCompleto2_2_1_ingles.fcl";
        int cont = 0;

        FIS fis = FIS.load(filename, true);

        if (fis == null) {
            System.err.println("Can't load file: '" + filename + "'");
            System.exit(1);
        }

        // Get default function block
        FunctionBlock fb = fis.getFunctionBlock(null);

        // Set inputs
        fb.setVariable("author_reputation", input.getAutor_reputation());
        fb.setVariable("patterns", input.getPadroes());
        fb.setVariable("correctness", input.getCorretude());

        // Evaluate
        fb.evaluate();

        // Show output variable's chart
        fb.getVariable("importance").defuzzify();

        if (chart) {
            JFuzzyChart.get().chart(fis);
        }
        
        
        // Exatamente como no arquivo FCL.
        if (fb.getVariable("importance").getValue() >= 0 && fb.getVariable("importance").getValue() <= 2) {
            aval = "IF";
        } else if (fb.getVariable("importance").getValue() > 2 && fb.getVariable("importance").getValue() <= 5) {
            aval = "SF";
        } else if (fb.getVariable("importance").getValue() > 5 && fb.getVariable("importance").getValue() <= 7) {
            aval = "BM";
        } else {
            aval = "PL";
        }

        HashMap<Double,String> retorno = new HashMap<Double,String>();
        retorno.put(fb.getVariable("importance").getValue(), aval);
        
        return retorno;
    }

    public static List<InputFuzzy> getInputs() throws FileNotFoundException {
        ArrayList<InputFuzzy> retorno = new ArrayList<InputFuzzy>();
        Scanner sc = new Scanner(new File("novoExpr.txt"));
        while (sc.hasNext()) {
            retorno.add(new InputFuzzy(sc.nextLine()));
        }
        return retorno;
    }
}