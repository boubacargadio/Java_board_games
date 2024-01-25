package fr.lecampusnumerique.cda2025.javaalgo.boardgames.games;

public interface Game {
    //Players[] getPlayers[];

    void play();
    void stop();
    void restart();
    void playRound();
    void PlayTurns();

    //XF.
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
    //
    protected int checkSize = 0;
    void setCheckSize(int input) {
        checkSize = input;
    }

    protected boolean isOver() {
        for(int a=0; a < myTable.length; a++) {
            for(int b=0; b < myTable.length; b++) { //for every cell
                //line
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

                //column
                same = true;
                curStr = myTable[a][b].getRepresentation();
                if(a+checkSize <= myTable.length) {
                    for (int c=0; c < checkSize; c++) {
                        if (myTable[a+c][b].getRepresentation() != curStr) {
                            same = false;
                        }
                    }
                    if(isOver_util(same, curStr)) {return true;}
                }

                //diagonal1
                same = true;
                curStr = myTable[a][b].getRepresentation();
                if(b+checkSize <= myTable[a].length &&
                        a+checkSize <= myTable.length) {

                    for(int c=0; c < checkSize; c++) {
                        if(myTable[a+c][b+c].getRepresentation() != curStr) {
                            same = false;
                        }
                    }
                    if(isOver_util(same, curStr)) {return true;}
                }

                //diagonal2
                same = true;
                curStr = myTable[a][b].getRepresentation();
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
        }

        return allCellFilled();
    }
}
