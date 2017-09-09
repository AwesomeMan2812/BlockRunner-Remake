package me.awesomeman2812.BlockRunner.enums;

public enum ArenaState {
	Lobby("Lobby"),
	Ingame("Ingame"),
	Starting("Starting"),
	Disabled("Disabled");

    private String state;
    ArenaState(String state){
        this.state = state;
    }

    @Override
    public String toString(){
        return state;
    }
}
