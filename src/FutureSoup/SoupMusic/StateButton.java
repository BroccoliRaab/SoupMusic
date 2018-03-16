package FutureSoup.SoupMusic;

import javafx.scene.control.Button;

public  abstract class StateButton extends Button {

    private int state;

    abstract void state0Action();
    abstract void state1Action();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public StateButton(int defaultState){

        this.state = defaultState;

        this.setOnAction(e ->{
            if (this.state == 0 ){
                state0Action();
                this.state = 1;
            }else if(this.state == 1){
                state1Action();
                this.state = 0;
            }

        });

    }
}
