@echo off

rem -------------------------------------------
rem 			Rappel
rem -------------------------------------------

rem Separateur:
rem
rem		Windows		;
rem		Linux/Mac	: 
rem
rem Classpath:
rem
rem		Acronyme:
rem
rem 		-cp
rem	
rem		Configuration:
rem
rem 		.			=> 	met dans le cp tous       .class   du repertoire courant 
rem 		./*			=> 	met dans le cp tous les    jar     du repertoire courant
rem			./ext/* 	=>	met dans le cp tous les    jar	   du folder ext
rem 
rem	Memoire:
rem
rem 	-Xms200m	memoire reservee par l'OS, que la jvm l'emploie ou pas!
rem 	-Xmx500m	memoire max que l'OS peut allouer au processus
rem
rem 	-verbose:gc		=> utile pour optimisation, affiche l'activite du garbage collector  (Warning: ne pas livrer chez le client)
rem
rem	Assertion:
rem
rem		-ea  	enable assertion
rem		-da		disable assertion
rem
rem Propriete System:
rem	
rem		-DnbFace=20	-DnbExperience=9999999
rem

rem -------------------------------------------
rem 			Tools
rem -------------------------------------------

rem ---------------
rem deploy local
rem ---------------

rem set JRE_PATH=./jvm/bin
 set JRE_PATH=C:\Soft\java\jdk\bin
 set PATH=%JRE_PATH%;%PATH%

rem ---------------
rem debug
rem ---------------

java -version
echo.

rem -------------------------------------------
rem 			Run                         
rem -------------------------------------------

set CLASS_PATH=.;./*;./ext/*

java -cp %CLASS_PATH% ch.hearc.dice.gui.UseGui

rem -------------------------------------------
rem 			end
rem -------------------------------------------

echo.
pause