package com.canva.intellij.searchinkibana;

public class SearchInKibanaStagingAction extends AbstractSearchInKibanaAction {
  public SearchInKibanaStagingAction() {
    super("https://logs.canva-corp.com/_plugin/kibana/app/discover#/?_g=(filters:!(),"
        + "refreshInterval:(pause:!t,value:0),time:(from:now-3d,to:now))&_a=(columns:!"
        + "(_source),filters:!(),index:'12f9e950-f846-11ec-a098-35551e84abe5',interval:auto,"
        + "query:(language:kuery,query:'%s'),sort:!())");
  }
}
