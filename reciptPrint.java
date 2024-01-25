package POS;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

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

    
    }


    private void resetReceipt() {
        receiptTextArea.setText("영수증이 여기에 표시됩니다.");
    }

    public static void main(String[] args) {
        // SwingUtilities.invokeLater(reciptPrint::new);

        Scanner stdIn = new Scanner(System.in);
        String posInput = stdIn.nextLine();
        String[] posInputs = posInput.split(" ");
        
        // 이 부분 메인에 활용할것 
        // import javax.swing.SwingUtilities;  # 라이브러리 import
        // SwingUtilities.invokeLater(() -> new reciptPrint(posInputs));  # 생성자 생성 실행 예약 -> 매개변수로 String[] posInputs  - 구매에 대한 영수증 출력
        SwingUtilities.invokeLater(() -> new reciptPrint(posInputs));


    }
}
