import { Route } from '@angular/router';

import { HomeComponent } from './';
import { BibliothequeComponent } from 'app/bibliotheque/bibliotheque.component';

export const HOME_ROUTE: Route = {
    path: '',
    component: HomeComponent,

    data: {
        authorities: [],
        pageTitle: 'Platformation'
    }
};
