package fr.lecampusnumerique.cda2025.javaalgo.boardgames.games;

public class GameClass implements Game {
    private boolean isOver_util(boolean same, String curStr) {
        if(same && curStr != Cell.EMPTY_STR) {
            if(curStr.equals(player1.getRepresentation())) {
                display();
                view.println("Joueur 1 a gagné!");
                return true;
            } else if(curStr.equals(player2.getRepresentation())) {
                display();
                view.println("Joueur 2 a gagné!");
                return true;
            }
        }
        return false;
    }

    protected int checkSize = 0;
    void setCheckSize(int input) {
        checkSize = input;
    }

    private boolean lineCheck() {
        boolean same = true;
        String curStr = myTable[a][b].getRepresentation();
        if(b+checkSize <= myTable[a].length) {
            for(int c=0; c < checkSize; c++) {
                if(myTable[a][b+c].getRepresentation() != curStr) {
                    same = false;
                }
            }
            if(isOver_util(same, curStr)) {return true;}
        }
    }
    private boolean columnCheck() {
        boolean same = true;
        String curStr = myTable[a][b].getRepresentation();
        if(a+checkSize <= myTable.length) {
            for (int c=0; c < checkSize; c++) {
                if (myTable[a+c][b].getRepresentation() != curStr) {
                    same = false;
                }
            }
            if(isOver_util(same, curStr)) {return true;}
        }
    }
    private boolean diagonal1Check() {
        boolean same = true;
        String curStr = myTable[a][b].getRepresentation();
        if(b+checkSize <= myTable[a].length &&
                a+checkSize <= myTable.length) {

            for(int c=0; c < checkSize; c++) {
                if(myTable[a+c][b+c].getRepresentation() != curStr) {
                    same = false;
                }
            }
            if(isOver_util(same, curStr)) {return true;}
        }
    }
    private boolean diagonal2Check() {
        boolean same = true;
        String curStr = myTable[a][b].getRepresentation();
        if(b+checkSize <= myTable[a].length &&
                a-checkSize >= -1) {

            for(int c=0; c < checkSize; c++) {
                if(myTable[a-c][b+c].getRepresentation() != curStr) {
                    same = false;
                }
            }
            if(isOver_util(same, curStr)) {return true;}
        }
    }

    protected boolean isOver() {
        for(int a=0; a < myTable.length; a++) {
            for(int b=0; b < myTable.length; b++) { //for every cell
                if(lineCheck()) {return true;}
                if(columnCheck()) {return true;}
                if(diagonal1Check()) {return true;}
                if(diagonal2Check()) {return true;}
            }
        }

        return allCellFilled();
    }
}
