import { Component, OnInit } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { LoginModalService, Principal, Account } from 'app/core';
import { HttpClient } from '@angular/common/http';
import { ActuBoxModel } from '../entities/actu-box.model';
import { SERVER_API_URL } from 'app/app.constants';

@Component({
    selector: 'jhi-home',
    templateUrl: './home.component.html',
    styleUrls: ['home.scss']
})
export class HomeComponent implements OnInit {
    account: Account;
    modalRef: NgbModalRef;
    infosActus: Array<ActuBoxModel>;

    constructor(
        private principal: Principal,
        private loginModalService: LoginModalService,
        private eventManager: JhiEventManager,
        private http: HttpClient
    ) {
        /*this.http.get('http://localhost:9000/data.json').subscribe((result: Array<ActuBoxModel>) => {
            //observable/promise : s'abonner à un event et on attend la reception des données et on peut faire un traitement après
            this.infosActus = result;
        });*/
        this.http.get(SERVER_API_URL + '/api/articles/all').subscribe((result: Array<ActuBoxModel>) => {
            this.infosActus = result;
        });
    }

    ngOnInit() {
        this.principal.identity().then(account => {
            this.account = account;
        });
        this.registerAuthenticationSuccess();
    }

    registerAuthenticationSuccess() {
        this.eventManager.subscribe('authenticationSuccess', message => {
            this.principal.identity().then(account => {
                this.account = account;
            });
        });
    }

    isAuthenticated() {
        return this.principal.isAuthenticated();
    }

    login() {
        this.modalRef = this.loginModalService.open();
    }
}
