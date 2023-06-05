import java.sql.SQLOutput;
import java.util.ArrayList;

public class List {
    public static void main(String[] args) {

        List<Memo> memoList = new ArrayList<>();

        }

        private int noteLength = 0;
        private final NoteEntity[] noteEntities;
        private final int NOTE_SIZE = 20;

        public void printNotes() {
            System.out.println("");
            if (0 == this.noteLength) {
                System.out.println("메모가 존재하지 않습니다.");
                System.out.println("");
                return;
            }
            for (int i = 0; i < this.noteLength; i++) {
                NoteEntity noteEntity = noteEntities[i];

                String headLine = String.format("번호:%d 제목:%s 작성날짜:%s", i, noteEntity.getTitle(), noteEntity.getLastUpdatedDateTime());
                System.out.println(headLine);
            }
            System.out.println("");


    }
}
