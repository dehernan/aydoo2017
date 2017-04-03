package ar.edu.untref.aydoo;

/**
 * Created by hernan on 24/03/17.
 */
public class Candidate{

    private String name;
    private PoliticalParty party;

    public Candidate(String candidateName, PoliticalParty candidateParty){

        name = candidateName;
        party = candidateParty;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PoliticalParty getParty() {
        return party;
    }

    public void setParty(PoliticalParty party) {
        this.party = party;
    }

}
