package RegradeNegocio;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GerarPdf {

   private String NomeDoAquivo;

    public void GerarPDF(String nomeArquivo, String texto) {
        Document doc = new Document(PageSize.A4);
        try {
            OutputStream output = new FileOutputStream(nomeArquivo + ".pdf");
            PdfWriter.getInstance(doc, output);
            doc.open();
            Paragraph p = new Paragraph(texto);
            PdfPTable tabela = new PdfPTable(6);
                PdfPCell header = new PdfPCell(new Paragraph("Titulo da Tabela"));
                header.setColspan(5);
                tabela.addCell(header);
                tabela.addCell("Texto Aleatorio.1");             
                doc.add(p);
                doc.add(tabela);

            doc.close();         
            JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso");
            
            
        } catch (DocumentException ex) {
            Logger.getLogger(GerarPdf.class.getName()).log(Level.SEVERE, null, ex);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GerarPdf.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public String getNomeDoAquivo() {
        return NomeDoAquivo;
    }

    public void setNomeDoAquivo(String NomeDoAquivo) {
        this.NomeDoAquivo = NomeDoAquivo;
    }

    

}
