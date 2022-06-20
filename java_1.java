import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfReader {

public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub

String filepath = "C:\\Users\\MSIGILAM\\OneDrive - Capgemini\\Documents\\Resume";

File ip = new File(filepath);

File[] fp = ip.listFiles();


for (File file : fp) {
PDDocument pdd = new PDDocument();
PDFTextStripper stripper = new PDFTextStripper();
String resume = stripper.getText(pdd.load(file));
String Resume = resume.toLowerCase();
pdd.load(file).close();
System.out.println(Resume);
Set<String> keywords = new HashSet();
keywords.add("core java");
keywords.add("python");
keywords.add("html");

// keywords.add("Joins");
int count = 0;
for (String ele : keywords) {
if (Resume.contains(ele)) {
System.out.println("yes");
count++;
}
}
if (count < 1) {
System.out.println("0%");
} else if (count == 1) {
System.out.println("50%");
} else if (count == 2) {
System.out.println("60%");
}
else if(count>2)
{
System.out.println("100%");
}
System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
}

}

}