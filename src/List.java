import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class List {
    public static void main(String[] args) {
        Memo.memoMap memoList = new ArrayList<>();
        }
        
        private int noteLength = 0;
        private final GetMemoList[] getMemoLists;
        private final int NOTE_SIZE = 20;

        public GetMemoList() {
            this.getMemoLists = new GetMemoList[NOTE_SIZE];
        }
        public void printNote() {
            System.out.println("");
            Scanner scanner = new Scanner(System.in);
            System.out.println("메모의 번호를 입력해주세요.");
            int selectedNumber = scanner.nextInt();
            GetMemoList getMemoList = getMemoLists[selectedNumber];
            if (null == getMemoList) {
                System.out.println("작성된 메모가 없습니다.");
                System.out.println("");
                return;
            }
        }

        public void printAllNotes() {
            System.out.println("");
            if (0 == this.noteLength) {
                System.out.println("메모가 존재하지 않습니다.");
                System.out.println("");
                return;
            }
            for (int i = 0; i < this.noteLength; i++) {
                GetMemoList getMemoList = getMemoLists[i];

                String headLine = String.format("번호:%d 제목:%s 작성날짜:%s", i, getMemoList.getTitle(), getMemoList.getLastUpdatedDateTime());
                System.out.println(headLine);
            }
            System.out.println("");
        }
    }
}
