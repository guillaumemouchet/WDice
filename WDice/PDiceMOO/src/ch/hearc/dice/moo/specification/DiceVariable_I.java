
package ch.hearc.dice.moo.specification;

import java.util.Map;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.tools.Chrono;
import ch.hearc.tools.algo.AlgoIteratif_I;

public interface DiceVariable_I extends AlgoIteratif_I // Voir annexe
	{

	// Outputs
	public Map<Integer, Integer> getMapFaceLancer();

	public Map<Integer, Chrono> getMapFaceChrono();

	// Inputs
	public Intervale getNbFaces(); // Interval du WDreamTeam

	public int getNbExperience();
	}
