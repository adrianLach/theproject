package de.tp.auftraege;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;

import de.tp.framework.sql.Buffer_auftraege;
import de.tp.framework.sql.Buffer_glaeubiger;
import de.tp.framework.sql.Filter;
import de.tp.framework.sql.SQL;

public class AuftraegeReport {
    
    public void generateReport() {
        
        Path tmpPath = null;
        try {
            tmpPath = Files.createTempFile(Paths.get("D:\\"), "print", ".csv");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        File file = tmpPath.toFile();
        
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        String columns = "Auftrags Nr.;Gläubiger Nr.;Gläubiger;Summe\n";
        
        try {
            fw.write(columns);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
        Buffer_glaeubiger bfGlaeubiger = new Buffer_glaeubiger(SQL.getDefaultConnection());
        
        HashMap<Integer, String> glaeubiger = new HashMap<>();
        
        bfGlaeubiger.reload(Filter.getFilter().select("*").from("glaeubiger"));
        try {
            ResultSet rsGlaeubiger = bfGlaeubiger.getResultSet();
            while (rsGlaeubiger.next()) {
                glaeubiger.put(rsGlaeubiger.getInt(1), rsGlaeubiger.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        Buffer_auftraege bfAuftraegeByDatum = new Buffer_auftraege(SQL.getDefaultConnection());
        bfAuftraegeByDatum.reload("SELECT auftragsdatum from auftraege group by auftragsdatum");
        
        try {
            ResultSet rsAuftraegeByDatum = bfAuftraegeByDatum.getResultSet();
            while (rsAuftraegeByDatum.next()) {
                
                try {
                    fw.write(rsAuftraegeByDatum.getDate(1) + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                Buffer_auftraege bfAuftraege = new Buffer_auftraege(SQL.getDefaultConnection());
                
                bfAuftraege.reload(Filter.getFilter().select("*").from("auftraege").where("auftragsdatum = '&1'")
                        .substitute(rsAuftraegeByDatum.getDate(1).toString()));
                
                ResultSet rsAuftraege = bfAuftraege.getResultSet();
                
                while (rsAuftraege.next()) {
                    
                    String row = "";
                    
                    row += rsAuftraege.getInt(1) + ";";
                    row += rsAuftraege.getInt(2) + ";";
                    row += glaeubiger.get(rsAuftraege.getInt(2)) + ";";
                    row += new DecimalFormat("#####0.00€").format(rsAuftraege.getDouble(4)) + "\n";
                    
                    System.out.println(row);
                    
                    try {
                        fw.write(row);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                
                try {
                    fw.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
