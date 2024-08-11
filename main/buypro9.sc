MISSION_START
			  

mission_start_washbuy:

SCRIPT_NAME	washbuy

flag_player_on_mission = 1

WAIT 0
{

	REMOVE_BLIP washbuy_blip
	PLAYER_MADE_PROGRESS 1

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 TRUE
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
	WHILE GET_FADING_STATUS
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT washbuyX washbuyY washbuyZ RADAR_SPRITE_SAVEHOUSE washbuy_blip 
			CHANGE_BLIP_DISPLAY washbuy_blip BLIP_ONLY
			//START_NEW_SCRIPT washsave1_save_loop
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDWHILE

	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT washbuyX washbuyY washbuyZ RADAR_SPRITE_SAVEHOUSE washbuy_blip 
	CHANGE_BLIP_DISPLAY washbuy_blip BLIP_ONLY
	//START_NEW_SCRIPT washsave1_save_loop

	CLEAR_AREA 90.7810 -806.1213 10.3349 1.0 TRUE
	SET_PLAYER_COORDINATES player1 90.7810 -806.1213 10.3349
	SET_PLAYER_HEADING player1 238.8605
	SWITCH_WIDESCREEN ON

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	SET_FIXED_CAMERA_POSITION 57.5999 -681.8762 10.4095 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 57.8653 -682.8020 10.6787 JUMP_CUT

	WHILE GET_FADING_STATUS
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDWHILE

	washington_1102_bought = 1
	//CREATE_CLOTHES_PICKUP 86.5 -810.4 11.7 1 safehouse_clothes3   
	safehouse_created3 = 1

	PRINT_WITH_NUMBER_BIG WASHBUY washbuy_price 5000 6 //1102 Washington Street purchased: $ ~1~
	ADD_MONEY_SPENT_ON_PROPERTY washbuy_price
	SET_PROPERTY_AS_OWNED PROP_WASHINGTON_STREET
	//washbuy_price *= -1
	//ADD_SCORE player1 washbuy_price
	PLAY_MISSION_PASSED_TUNE 1
	SET_MUSIC_DOES_FADE FALSE

	WAIT 2000

//	IF NOT IS_PLAYER_PLAYING player1
//		SET_MUSIC_DOES_FADE TRUE
//		TERMINATE_THIS_SCRIPT
//	ENDIF
//
//	SET_FIXED_CAMERA_POSITION 94.9633 -798.4363 14.1172 0.0 0.0 0.0
//	POINT_CAMERA_AT_POINT 94.2972 -799.1451 13.8847 JUMP_CUT

	PRINT_NOW BUYSAVE 3000 1//~g~You can now save your game here for free.

	WAIT 3000

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT

	WHILE GET_FADING_STATUS
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			SET_MUSIC_DOES_FADE TRUE
			TERMINATE_THIS_SCRIPT
		ENDIF
	ENDWHILE

	SET_CAMERA_BEHIND_PLAYER
	RESTORE_CAMERA_JUMPCUT

	SET_PLAYER_CONTROL player1 ON
	SET_EVERYONE_IGNORE_PLAYER player1 FALSE
	SET_ALL_CARS_CAN_BE_DAMAGED TRUE
	SWITCH_WIDESCREEN OFF

	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_IN

	GOSUB get_fading_status

	SET_MUSIC_DOES_FADE TRUE
					
												
flag_player_on_mission = 0

MISSION_HAS_FINISHED
MISSION_END

}
RETURN 
