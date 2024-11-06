package com.canva.intellij.searchinkibana;

public class SearchInKibanaDevAction extends AbstractSearchInKibanaAction {
  public SearchInKibanaDevAction() {
    super("https://logs.canva-corp.com/_plugin/kibana/app/discover#/?_g=(filters:!(),"
        + "refreshInterval:(pause:!t,value:0),time:(from:now-3d,to:now))&_a=(columns:!"
        + "(_source),filters:!(),index:'941e1550-002a-11ee-bf8e-fb1de8e178b4',interval:auto,"
        + "query:(language:kuery,query:'%s'),sort:!())");
  }
}
