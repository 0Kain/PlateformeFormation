import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { errorRoute, navbarRoute } from './layouts';
import { DEBUG_INFO_ENABLED } from './app.constants';
import { BibliothequeComponent } from './bibliotheque/bibliotheque.component';
import { CreateArticleComponent } from './create-article/create-article.component';
import { CoursComponent } from './bibliotheque/cours/cours.component';
import { ArticleComponent } from 'app/article/article.component';

const LAYOUT_ROUTES = [navbarRoute, ...errorRoute];

@NgModule({
    imports: [
        RouterModule.forRoot(
            [
                ...LAYOUT_ROUTES,
                { path: 'admin', loadChildren: './admin/admin.module#PlatformationAdminModule' },
                { path: 'bibliotheque', component: BibliothequeComponent },
                { path: 'create-article', component: CreateArticleComponent },
                { path: 'article', component: ArticleComponent }
            ],
            { useHash: true, enableTracing: DEBUG_INFO_ENABLED }
        )
    ],
    exports: [RouterModule]
})
export class PlatformationAppRoutingModule {}
