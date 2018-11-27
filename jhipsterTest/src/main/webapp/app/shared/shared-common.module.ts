import { NgModule } from '@angular/core';

import { PlatformationSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';
import { ActuBoxComponent } from '../home/actu-box/actu-box.component';

@NgModule({
    imports: [PlatformationSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [PlatformationSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class PlatformationSharedCommonModule {}
