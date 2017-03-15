/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.rhecruta.shared.domain.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author Pedro Arthur
 * 
 */
@Entity
public class Invite implements Serializable {
    
    @EmbeddedId
    private InvitePK invitePK;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("offerId")
    @JoinColumn(name = "offer_id")
    private Offer offer;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("invitedId")
    @JoinColumn(name = "invited_id")
    private Candidate invited;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("inviterId")
    @JoinColumn(name = "inviter_id")
    private Administrator inviter;
    
    private boolean accepted;

    public Invite(Offer offer, Candidate invited, Administrator inviter, boolean accepted) {
        this.offer = offer;
        this.invited = invited;
        this.inviter = inviter;
        this.accepted = accepted;
    }

    public Invite() {
        
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Candidate getInvited() {
        return invited;
    }

    public void setInvited(Candidate invited) {
        this.invited = invited;
    }

    public Administrator getInviter() {
        return inviter;
    }

    public void setInviter(Administrator inviter) {
        this.inviter = inviter;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public String toString() {
        return "Invite{" + "offer=" + offer + ", invited=" + invited + ", inviter=" + inviter + ", accepted=" + accepted + '}';
    }
}