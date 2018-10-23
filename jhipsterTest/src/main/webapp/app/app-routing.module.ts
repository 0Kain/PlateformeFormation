import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { errorRoute, navbarRoute } from './layouts';
import { DEBUG_INFO_ENABLED } from 'app/app.constants';
import { BibliothequeComponent } from 'app/bibliotheque/bibliotheque.component';

const LAYOUT_ROUTES = [navbarRoute, ...errorRoute];

@NgModule({
    imports: [
        RouterModule.forRoot(
            [
                ...LAYOUT_ROUTES,
                { path: 'admin', loadChildren: './admin/admin.module#PlatformationAdminModule' },
                { path: 'bibliotheque', component: BibliothequeComponent }
            ],
            { useHash: true, enableTracing: DEBUG_INFO_ENABLED }
        )
    ],
    exports: [RouterModule]
})
export class PlatformationAppRoutingModule {}
