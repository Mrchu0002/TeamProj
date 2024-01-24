package POS;

import java.awt.Desktop;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;

public class reciptPrint extends JFrame {

    private JTextArea receiptTextArea;

    public reciptPrint(String[] posInputs) {
        // 프레임 설정
        setTitle("영수증 프로그램");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 패널 생성 및 레이아웃 설정
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1)); // 2행 1열

        // 영수증 텍스트 영역 설정
        receiptTextArea = new JTextArea();
        receiptTextArea.setEditable(false);

        // 영수증 초기화
        resetReceipt();

        // 스크롤 가능한 패널에 텍스트 영역 추가
        JScrollPane scrollPane = new JScrollPane(receiptTextArea);
        mainPanel.add(scrollPane);

        // 버튼 패널 설정
        JPanel buttonPanel = new JPanel();
        JButton printButton = new JButton("영수증 출력");
        printButton.addActionListener(e -> printReceipt(posInputs));
        JButton resetButton = new JButton("영수증 초기화");
        resetButton.addActionListener(e -> resetReceipt());
        buttonPanel.add(printButton);
        buttonPanel.add(resetButton);

        // 버튼 패널 추가
        mainPanel.add(buttonPanel);

        // 프레임에 메인 패널 추가
        add(mainPanel);

        // 프레임 표시
        setVisible(true);
    }

    private void printReceipt(String[] posInputs) {
        String name = posInputs[1]; // 상품명
        String cateId = posInputs[2]; // 분류 ID
        String cst = posInputs[3]; // 가격
        String cnt = posInputs[4];// 재고

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime = dateFormat.format(new Date());

        String receiptText = "-------------------------------------------------\n" +
                             "                      영수증                     \n" +
                             "-------------------------------------------------\n" +
                             "일시:     "+ dateTime +"                         \n" +
                             "-------------------------------------------------\n" +
                             "상품명                수량              가격     \n" +
                             "-------------------------------------------------\n" +
                             name+"                "+cnt+"              "+cst+"  \n" +
                            //  name+"       "+cnt+"        "+cst+"\n" +
                             "-------------------------------------------------\n" +
                             "총 합계:                  "+Integer.parseInt(cnt) * Integer.parseInt(cst) +"원\n" +
                             "-------------------------------------------------\n";

                        

        receiptTextArea.setText(receiptText);

         // PDF 생성 및 출력
         createPDF(receiptText);
    }

    private void createPDF(String content) {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDType1Font fontstyle = new PDType1Font("HELVETICA_BOLD")
        

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(10, 750);
            contentStream.showText(content);
            contentStream.endText();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file = new File("receipt.pdf");
            document.save(file);
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void resetReceipt() {
        receiptTextArea.setText("영수증이 여기에 표시됩니다.");
    }

    public static void main(String[] args) {
        // SwingUtilities.invokeLater(reciptPrint::new);

        Scanner stdIn = new Scanner(System.in);
        String posInput = stdIn.nextLine();
        String[] posInputs = posInput.split(" ");
        
        SwingUtilities.invokeLater(() -> new reciptPrint(posInputs));


    }
}
