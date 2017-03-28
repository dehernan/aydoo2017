package ar.edu.untref.aydoo;
import java.util.*;

/**
 * Created by hernan on 24/03/17.
 */
public class PresidentialPrimaryElection {

    private List votes = new ArrayList<Vote>();
    private List politicalParties = new ArrayList<PoliticalParty>();
    private List candidates = new ArrayList<Candidate>();

    public List getVotes() {
        return votes;
    }

    public List getPoliticalParties() {
        return politicalParties;
    }

    public List getCandidates() {
        return candidates;
    }

    public void newPoliticalParty(String name){

        this.politicalParties.add(new PoliticalParty(name));

    }

    public PoliticalParty getPoliticalParty(String name){

        Iterator<PoliticalParty> iterator = politicalParties.iterator();

        while(iterator.hasNext()){

            PoliticalParty politicalParty = iterator.next();
            if(politicalParty.getName() == name){

                return politicalParty;

            }
        }

        return null;

    }


    public void newCandidate(String candidateName, PoliticalParty candidateParty){

        this.candidates.add(new Candidate(candidateName, candidateParty));

    }

    public Candidate getCandidate(String name){

        Iterator<Candidate> iterator = candidates.iterator();

        while(iterator.hasNext()){

            Candidate candidate = iterator.next();

            if(candidate.getName() == name){

                return candidate;

            }
        }

        return null;

    }

    public void newVote(Province province, Candidate candidate){

        votes.add(new Vote(province, candidate));

    }

    public int votesByParty(PoliticalParty party) {

        int partyVotes = 0;

        Iterator<Vote> iterator = votes.iterator();
        while (iterator.hasNext()) {

            if (iterator.next().getPoliticalParty() == party) {

                partyVotes++;

            }

        }

        return partyVotes;

    }

    public int votesByPartyAndProvince(Province province, PoliticalParty party){

        int provinceVotes = 0;

        Iterator<Vote> iterator = votes.iterator();

        while(iterator.hasNext()){

            Vote actualVote = iterator.next();
            if(actualVote.getPoliticalParty() == party && actualVote.getProvince() == province){

                provinceVotes++;

            }

        }

        return provinceVotes;

    }

    public int votesByProvince(Province province){

        int provinceVotes = 0;

        Iterator<Vote> iterador = votes.iterator();
        while(iterador.hasNext()) {

            if (iterador.next().getProvince() == province) {

                provinceVotes++;

            }

        }

        return provinceVotes;

    }

    public int votesByCandidate(Candidate candidate){

        int candidateVotes = 0;

        Iterator<Vote> iterator = votes.iterator();
        while(iterator.hasNext()) {

            if (iterator.next().getCandidate() == candidate) {

                candidateVotes++;

            }

        }

        return candidateVotes;

    }


    public int votesByCandidateAndProvince(Province province, Candidate candidate){

        int candidateVotes = 0;

        Iterator<Vote> iterator = votes.iterator();
        while ((iterator.hasNext())){

            Vote actualVote = iterator.next();
            if(actualVote.getCandidate() == candidate && actualVote.getProvince() == province){

                candidateVotes++;

            }

        }

        return candidateVotes;

    }

    public String nationallyMostVotedCandidate(){

        String winnerCandidate = "";
        int winnerVotes = 0;

        Iterator<Candidate> iterator = candidates.iterator();

        while(iterator.hasNext()){

            Candidate actualCandidate = iterator.next();
            int actualCandidateVotes = this.votesByCandidate(actualCandidate);

            if(actualCandidateVotes>winnerVotes){

                winnerCandidate = actualCandidate.getName();
                winnerVotes = actualCandidateVotes;


            }

        }

        return winnerCandidate;


    }

    public String provinciallyMostVotedCandidate(Province province){

        String winnerCandidate = "";
        int winnerVotes = 0;

        Iterator<Candidate> iterator = candidates.iterator();

        while(iterator.hasNext()){

            Candidate actualCandidate = iterator.next();
            int actualCandidateVotes = this.votesByCandidateAndProvince(province, actualCandidate);

            if(actualCandidateVotes>winnerVotes){

                winnerCandidate = actualCandidate.getName();
                winnerVotes = actualCandidateVotes;

            }

        }

        return winnerCandidate;

    }

    public String nationallyMostVotedParty(){

        String winnerParty = "";
        int winnerVotes = 0;

        Iterator<Candidate> iterator = candidates.iterator();

        while(iterator.hasNext()){

            Candidate actualCandidate = iterator.next();
            int actualPartyVotes = this.votesByParty(actualCandidate.getParty());

            if(actualPartyVotes > winnerVotes){

                winnerParty = actualCandidate.getParty().getName();
                winnerVotes = actualPartyVotes;

            }

        }

        return winnerParty;

    }

    public String provinciallyMostVotedParty(Province province){

        String winnerParty = "";
        int winnerVotes = 0;

        Iterator<Candidate> iterator = candidates.iterator();

        while(iterator.hasNext()){
            Candidate actualCandidate = iterator.next();
            int actualPartyVotes = this.votesByPartyAndProvince(province, actualCandidate.getParty());

            if(actualPartyVotes> winnerVotes){

                winnerVotes = actualPartyVotes;
                winnerParty = actualCandidate.getParty().getName();

            }

        }

        return winnerParty;

    }

}
