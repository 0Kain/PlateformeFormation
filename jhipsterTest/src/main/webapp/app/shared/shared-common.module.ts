import { NgModule } from '@angular/core';

import { PlatformationSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [PlatformationSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [PlatformationSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class PlatformationSharedCommonModule {}
