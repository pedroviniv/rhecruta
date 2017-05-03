/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.rhecruta.web.beans;

import br.edu.ifpb.dac.rhecruta.shared.domain.entities.Candidate;
import br.edu.ifpb.dac.rhecruta.shared.domain.entities.Enterview;
import br.edu.ifpb.dac.rhecruta.shared.domain.entities.Offer;
import br.edu.ifpb.dac.rhecruta.shared.interfaces.EnterviewService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Pedro Arthur
 */

@Named
@ConversationScoped
public class EnterviewBean implements Serializable {
    
    @Inject
    private Conversation conversation;
    
    @Inject
    private EnterviewService enterviewService;
    
    private Offer selectedOffer;
    private Candidate selectedCandidate;
    private Enterview enterview;
    
    private List<Enterview> enterviewsList;
    
    @PostConstruct
    public void init() {
        initAttributes();
        listEnterviews();
    }
    
    private void initAttributes() {
        this.selectedOffer = new Offer();
        this.selectedCandidate = new Candidate();
        this.enterview = new Enterview();
    }
    
    private void listEnterviews() {
        this.enterviewsList = this.enterviewService.listAll();
    }
    
    public String saveEnterview() {
        
        enterview.setCandidate(selectedCandidate);
        enterview.setOffer(selectedOffer);
        
        try {
            
            this.enterviewService.save(enterview);
            
            addMessage("enterviewMsg", 
                    createMessage("The enterview was scheduled successfully!", 
                            FacesMessage.SEVERITY_INFO));
            
            initAttributes();
            endConversation();
            
            return "enterviews";
            
        } catch (EJBException ex) {
            addMessage("enterviewMsg", 
                    createMessage(ex.getCausedByException().getMessage(), 
                            FacesMessage.SEVERITY_ERROR));
            
            return null;
        }
    }
    
    private FacesMessage createMessage(String text, Severity severity) {
        FacesMessage message = new FacesMessage(text);
        message.setSeverity(severity);
        return message;
    }
    
    private void addMessage(String clientId, FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(clientId, message);
    }
    
    public String newEnterview(Offer offer, Candidate candidate) {
        initConversation();
        
        this.selectedOffer = offer;
        this.selectedCandidate = candidate;
        
        return "new_enterview";
    }

    public Offer getSelectedOffer() {
        return selectedOffer;
    }

    public void setSelectedOffer(Offer selectedOffer) {
        this.selectedOffer = selectedOffer;
    }

    public Candidate getSelectedCandidate() {
        return selectedCandidate;
    }

    public void setSelectedCandidate(Candidate selectedCandidate) {
        this.selectedCandidate = selectedCandidate;
    }

    public List<Enterview> getEnterviewsList() {
        return enterviewsList;
    }

    public void setEnterviewsList(List<Enterview> enterviewsList) {
        this.enterviewsList = enterviewsList;
    }
    
    public void initConversation() {
        if (conversation.isTransient()) {
            this.conversation.begin();
        }
    }

    public void endConversation() {
        if (!conversation.isTransient()) {
            this.conversation.end();
        }
    }
}