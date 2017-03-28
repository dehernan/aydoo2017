package ar.edu.untref.aydoo;

/**
 * Created by hernan on 24/03/17.
 */
public class Vote {

    private Province province;
    private Candidate candidate;
    private PoliticalParty politicalParty;


    public Vote(Province province, Candidate candidate){

        this.candidate = candidate;
        this.province = province;
        this.politicalParty = candidate.getParty();

    }

    public Province getProvince() {
        return province;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public PoliticalParty getPoliticalParty() {
        return politicalParty;
    }
}
