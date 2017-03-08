/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.rhecruta.shared.domain.enums;

/**
 *
 * @author Pedro Arthur
 */
public enum Role {
    
    CANDIDATE(1), MANAGER(2), APPRAISER(3);
    
    int type;
    
    Role(int type) {
        this.type = type;
    }
    
    public int getType() {
        return type;
    }
}
