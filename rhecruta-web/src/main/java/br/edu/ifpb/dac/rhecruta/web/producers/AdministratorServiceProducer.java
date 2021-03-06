/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.rhecruta.web.producers;

import br.edu.ifpb.dac.rhecruta.shared.interfaces.AdministratorService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

/**
 *
 * @author Pedro Arthur
 */

@ApplicationScoped
public class AdministratorServiceProducer {
    
    private static final String RESOURCE = "java:global/rhecruta-core/AdministratorServiceImpl!br.edu.ifpb.dac.rhecruta.shared.interfaces.AdministratorService";
    
    @Dependent
    @Produces
    @Default
    private AdministratorService getAdministratorService() {
        return new ServiceLocator().lookup(RESOURCE, AdministratorService.class);
    }
}
