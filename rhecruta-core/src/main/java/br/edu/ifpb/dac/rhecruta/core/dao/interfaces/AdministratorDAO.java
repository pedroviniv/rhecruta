/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.rhecruta.core.dao.interfaces;

import br.edu.ifpb.dac.rhecruta.shared.domain.entities.Administrator;
import br.edu.ifpb.dac.rhecruta.shared.domain.entities.User;
import br.edu.ifpb.dac.rhecruta.shared.domain.enums.Role;

/**
 *
 * @author Pedro Arthur
 */
public interface AdministratorDAO extends DAO<Administrator> {
    
    Administrator getAdministratorByUser(User user);
    //void changeRole(Administrator administrator, Role newRole);
    void delete(Administrator administrator);
}