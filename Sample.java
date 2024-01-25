package POS;

class Sample {

    private String[] RM100 = {"101 신라면 1000 50",
        "102 삼양라면 1000 30",
        "103 진매 1000 50",
        "104 진순 1000 40",
        "105 너구리 1000 30",
        "106 열라면 1000 50",
        "107 틈새라면 1200 30",
        "108 안성탕면 1000 40",
        };

    private String[] RM200 = { "201 사리곰탕 1200 30",
        "202 나가사끼짬뽕 1200 30",
        "203 꼬꼬면 1400 20",
        "204 멸치칼국수 1400 30",
        "205 북엇국라면 1200 20"
    };

    private String[] RM300 = {
        "301 불닭 1200 50",
        "302 신라면볶음면 1200 30",
        "303 볶음너구리 1200 30",
        "305 틈새볶음면 1400 20",
        "306 짜파게티 1200 50",
    };

    private String[] RM400 = {
        "401 팔도비빔 1200 50",
        "402 진비빔면 1300 30",
        "403 배홍동 1400 40",
        "404 열무비빔 1500 20",
        "405 쫄면 1200 20"
    };

    private String[] RM500 = {
        "501 신라면 1000 50",
        "502 튀김우동 1400 50",
        "503 왕뚜껑 1200 50",
        "504 짜파게티 1200 40",
        "505 불닭 1200 50",
        "506 열라면 1000 40",
        "507 김치찌개라면 1500 40"
    };

    public String[] idSplitter(String[] dataSet) {
        // int index = 0;
        String[] cateId = new String[dataSet.length];  //분류코드
       
        // data set    - >  Stirng [] dataset 이 들어오면  dataSet[0] 의 구조 
        // "500 신라면 1000 50"  -> "코드 상품명 가격 수량" 을 잘라서 각각 결과로 리턴
        for (int index= 0 ; index < dataSet.length; index++) {
            String data = dataSet[index]; // dataSet에서 한줄 추출
            String[] temp = new String[4];   // 0  , 1   ,  2  ,  3  String 배열
            temp = data.split(" "); //공백으로 자르기

            cateId[index] = "RM"+temp[0]; //분류코드 RM + "숫자" format
        }
        return cateId;
    }


    public String[] nameSplitter(String[] dataSet) {
        // int index = 0;
        String[] name = new String[dataSet.length];  //상품명
    
        // data set    - >  Stirng [] dataset 이 들어오면  dataSet[0] 의 구조 
        // "500 신라면 1000 50"  -> "코드 상품명 가격 수량" 을 잘라서 각각 결과로 리턴
        for (int index= 0 ; index < dataSet.length; index++) {
            String data = dataSet[index]; // dataSet에서 한줄 추출
            String[] temp = new String[4];   // 0  , 1   ,  2  ,  3  String 배열
            temp = data.split(" "); //공백으로 자르기

            name[index] = temp[1];
        }
        return name; // name 이라는 String 배열 반환
    }

    public String[] costSplitter(String[] dataSet) {
        // int index = 0;
        String[] cst = new String[dataSet.length];    //cost = 상품가격

        // data set    - >  Stirng [] dataset 이 들어오면  dataSet[0] 의 구조 
        // "500 신라면 1000 50"  -> "코드 상품명 가격 수량" 을 잘라서 각각 결과로 리턴
        for (int index= 0 ; index < dataSet.length; index++) {
            String data = dataSet[index]; // dataSet에서 한줄 추출
            String[] temp = new String[4];   // 0  , 1   ,  2  ,  3  String 배열
            temp = data.split(" "); //공백으로 자르기

            cst[index] = temp[2];
        }
        return cst;
    }

    public String[] contSplitter(String[] dataSet) {
        // int index = 0;
        String[] cnt = new String[dataSet.length];         //count = 상품수량

        // data set    - >  Stirng [] dataset 이 들어오면  dataSet[0] 의 구조 
        // "500 신라면 1000 50"  -> "코드 상품명 가격 수량" 을 잘라서 각각 결과로 리턴
        for (int index= 0 ; index < dataSet.length; index++) {
            String data = dataSet[index]; // dataSet에서 한줄 추출
            String[] temp = new String[4];   // 0  , 1   ,  2  ,  3  String 배열
            temp = data.split(" "); //공백으로 자르기

            cnt[index] = temp[3];
        }
        return cnt;
    }


    public String[] getRM100() {
        return RM100;
    }


    public String[] getRM200() {
        return RM200;
    }


    public String[] getRM300() {
        return RM300;
    }


    public String[] getRM400() {
        return RM400;
    }


    public String[] getRM500() {
        return RM500;
    }

}




// public class sampleData {


//     public static void main(String[] args) {
//         // String[] rm100 = RM100;
//         // rm100.toString();
//         // System.out.println(rm100[1]);
//         Sample sample = new Sample();
//         String[] rm100 =  sample.getRM100();

        
//         String[] cateId = sample.idSplitter(rm100);
//         String[] name = sample.nameSplitter(rm100);
//         String[] cst = sample.costSplitter(rm100);
//         String[] cnt = sample.costSplitter(rm100);
//     }

// }
