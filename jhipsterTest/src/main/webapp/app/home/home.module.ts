import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { PlatformationSharedModule } from 'app/shared';
import { HOME_ROUTE, HomeComponent } from './';
import { ActuBoxComponent } from './actu-box/actu-box.component';

@NgModule({
    imports: [PlatformationSharedModule, RouterModule.forChild([HOME_ROUTE])],
    declarations: [HomeComponent, ActuBoxComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PlatformationHomeModule {}
